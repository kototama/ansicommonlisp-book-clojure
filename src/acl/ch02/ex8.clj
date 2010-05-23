(ns acl.ch02.ex8)

(defn print-dots-iter [n]
  (dotimes [x n]
    (print "."))
  (print "\n"))

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

(defn count-a2 [l]
  (reduce (fn [acc x]
            (if (= x 'a)
              (inc acc)
              acc))
          0
          l))

;; with tail-call optimization
(defn count-a3 [col]
  (loop [n 0
         l col]
   (if (empty? l)
     n
     (if (= (first l) 'a)
       (recur (inc n) (rest l))
       (recur n (rest l))))))
