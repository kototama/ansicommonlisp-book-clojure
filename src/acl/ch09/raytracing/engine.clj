(ns acl.ch09.raytracing.engine
  (:use [clojure.java.io :only (writer)]
        acl.ch09.raytracing.math-utils)
  (:import acl.ch09.raytracing.math-utils.Point))

(defprotocol Surface
  (color [this])
  (intersect [this pt xr yr zr])
  (normal [this pt]))

(def *eye* (Point. 0 0 200))

(defmacro with-out-file [filename & body]
  `(binding [*out* (writer ~filename)] ~@body))

(defn lambert [s i xr yr zr]
  (let [[xn yn zn] (normal s i)]
    (max 0 (+ (* xr xn) (* yr yn) (* zr zn)))))

(defn first-hit [pt xr yr zr world]
  (reduce (fn [acc s]
            (let [[surface hit dist] acc]
              (if-let [h (intersect s pt xr yr zr)]
                (let [d (distance h pt)]
                  (if (or (nil? dist) (< d dist))
                    [s h d]
                    acc))
                acc)))
          nil
        world))

(defn sendray [pt xr yr zr world]
  (if-let [hitinfo (first-hit pt xr yr zr world)]
    (let [[s i] hitinfo]
      (* (lambert s i xr yr zr) (color s)))
    0))

(defn color-at [x y world]
  (let [[xr yr zr] (unit-vector (- x (:x *eye*))
                                (- y (:y *eye*))
                                (- 0 (:z *eye*)))]
    (int (* (sendray *eye* xr yr zr world) 255))))

(defn tracer
  ([pathname world]
     (tracer pathname world 1))
  ([pathname world res]
     (with-out-file pathname
       (printf "P2 %d %d 255" (* res 100) (* res 100))
       (let [inc (/ res)]
         (dorun
          (for [y (range -50 50 res)
                x (range -50 50 res)]
            (printf "%d " (color-at x y world))))
         (prn)))))

