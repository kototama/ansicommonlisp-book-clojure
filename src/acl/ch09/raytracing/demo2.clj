(ns acl.ch09.raytracing.demo2
  (:use (acl.ch09.raytracing sphere engine)))

(defn spiral [a]
  ;; see http://www.mathematische-basteleien.de/spiral.htm
  (map (fn [t]
         [(* a t (Math/cos t))
          (* a t (Math/sin t))])
       (range 0 (* 6 Math/PI) 0.1)))

(defn -main []
  (let [res 5
        world (first
               (reduce (fn [[world z] [x y]]
                         [(conj world (create-sphere x y z 5 0.75))
                          (+ z 10)])
                       [() 270]
                       (spiral 20)))]
    (tracer "spheres.pgm" world res)))