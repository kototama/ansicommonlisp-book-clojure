(defn stable-union [l1 l2]
  (distinct (concat l1 l2)))

(stable-union '(:a :b :c) '(:b :a :d)) ;; (:a :b :c :d)

