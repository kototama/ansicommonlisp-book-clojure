(ns acl.ch09.raytracing.demo
  (:use clojure.pprint
        acl.ch09.raytracing.sphere
        acl.ch09.raytracing.engine))

(defn -main []
  (let [res 1
        world (concat
               [(create-sphere 0 -300 -1200 200 0.8)
                (create-sphere -80 -150 -1200 200 0.7)
                (create-sphere 70 -100 -1200 200 0.9)]
               (for [x (range -2 2)
                     z (range 2 7)]
                 (create-sphere (* x 200) 300 (* z -400) 40 0.75)))]
    (tracer "spheres.pgm" world res)))