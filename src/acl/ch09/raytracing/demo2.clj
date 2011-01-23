(ns acl.ch09.raytracing.demo2
  (:use (acl.ch09.raytracing sphere engine)))

(defn spiral [a]
  ;; see http://www.mathematische-basteleien.de/spiral.htm
  (map (fn [t]
         [(* a t (Math/cos t))
          (* a t (Math/sin t))])
       (range 0 (* 6 Math/PI) 0.1)))

(defn -main []
  (let [res 10
        world (map (fn [[x y]]
                     (create-sphere x y 700 5 0.75))
                   (spiral 10))]
    (tracer "spheres.pgm" world res)))