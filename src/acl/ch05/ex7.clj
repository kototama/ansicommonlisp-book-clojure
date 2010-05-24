(ns acl.ch05.ex7)

(defn continuous-pairs? [col]
  (every? (fn [[x y]] (= (Math/abs (- x y)) 1)) (partition 2 col)))
