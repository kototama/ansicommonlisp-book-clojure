;; does not make so much sense since values
;; are immutable
(defn bst-adjoin [bst x comp]
  (if (bst-find bst x comp)
    bst
    (bst-insert bst x comp)))


(comment

  (def nums (reduce (fn [acc x] (bst-insert acc x <)) nil [5 8 4 2 1 9 6 7 3]))
  
  (def t1 (bst-adjoin nums 8 <))
  (def t2 (bst-insert nums 8 <))

  ;; nonetheless equal
  (= t1 t2)
)

