(ns acl.ch09.raytracing.sphere
  (:use acl.ch09.raytracing.engine
        acl.ch09.raytracing.math-utils)
  (:import acl.ch09.raytracing.math-utils.Point))

(defrecord Sphere [radius center color]
  Surface
  
  (color
   [this]
   color)
  
  (intersect
   [this pt xr yr zr]
   (when-let [n (minroot (+ (sq xr) (sq yr) (sq zr))
                         (* 2 (+ (* (- (:x pt) (:x center)) xr)
                                 (* (- (:y pt) (:y center)) yr)
                                 (* (- (:z pt) (:z center)) zr)))
                         (+ (sq (- (:x pt) (:x center)))
                            (sq (- (:y pt) (:y center)))
                            (sq (- (:z pt) (:z center)))
                            (- (sq radius))))]
     (Point. (+ (:x pt) (* n xr))
             (+ (:y pt) (* n yr))
             (+ (:z pt) (* n zr)))))
  
  (normal
   [this pt]
   (unit-vector (- (:x center) (:x pt))
                (- (:y center) (:y pt))
                (- (:z center) (:z pt)))))

(defn create-sphere [x y z r c]
  (Sphere. r (Point. x y z) c))
