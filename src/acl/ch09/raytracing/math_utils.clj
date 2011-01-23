(ns acl.ch09.raytracing.math-utils
  (:use [clojure.contrib.math :only (sqrt)]))
         
(defrecord Point [x y z])

(defn sq [x]
  (Math/pow x 2))

(defn mag [x y z]
  (sqrt (+ (sq x) (sq y) (sq z))))

(defn unit-vector [x y z]
  (let [d (mag x y z)]
    [(/ x d) (/ y d) (/ z d)]))

(defn distance [p1 p2]
  (mag (- (:x p1) (:x p2))
       (- (:y p1) (:y p2))
       (- (:z p1) (:z p2))))

(defn minroot [a b c]
  (if (zero? a)
    (/ (- c) b)
    (let [disc (- (sq b) (* 4 a c))]
      (when-not (neg? disc)
        (let [discrt (sqrt disc)]
          (min (/ (+ (- b) discrt) (* 2 a))
               (/ (- (- b) discrt) (* 2 a))))))))