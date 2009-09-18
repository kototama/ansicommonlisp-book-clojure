
(defn print-dots [n]
  (if (> n 0)
      (do
	(print ".")
	(print-dots (- n 1)))
      (print "\n")))


(defn count-a [l]
  (if (empty? l)
      0
      (if (= (first l) 'a)
	  (+ 1 (count-a (rest l)))
	  (count-a (rest l)))))

(count-a nil) ;; 0
(count-a '(a a a)) ;; 3
(count-a '(oo ll ee)) ;; 0
