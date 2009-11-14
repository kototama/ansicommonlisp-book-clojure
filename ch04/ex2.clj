
;; makes not so much sense since values are immutables
(defn copy-list [l]
  (reverse (reduce (fn [acc x] (cons x acc)) '() l)))

(defn my-reverse [l]
  (reduce (fn [acc x] (cons x acc)) '() l))


(comment

  (= (my-reverse '(:a :b :c)) '(:c :b :a))

)
