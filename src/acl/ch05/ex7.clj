(use 'clojure.contrib.import-static)
(import-static java.lang.Math abs)

(defn continuous-pairs? [col]
  (every? (fn [[x y]] (= (abs (- x y)) 1)) (partition 2 col)))
