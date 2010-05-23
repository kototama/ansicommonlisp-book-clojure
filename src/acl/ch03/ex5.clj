(use '[clojure.contrib.seq-utils :only (indexed)])
    
(defn pos+ [col]
  (map (fn [x] (+ (first x) (second x))) (indexed col)))

(defn pos+2 [col]
  (loop [res '() 
	 l col
	 acc 0]
    (if-not (empty? l)
      (recur (conj res (+ (first l) acc)) (rest l) (inc acc))
      (reverse res))))
      
(pos+ [7 5 1 4]) ;; (7 6 3 7)

(pos+2 '(7 5 1 4)) ;; (7 6 3 7)
