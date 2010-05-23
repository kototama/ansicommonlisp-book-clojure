(defn contains-list? [l]
  (if (empty? l)
      false
      (or (list? (first l))
	  (contains-list? (rest l)))))


(contains-list? '(a b c)) ;; false
(contains-list? nil) ;; false
(contains-list? '(a nil c)) ;; false
(contains-list? '(a '(aa bb) c)) ;; true
