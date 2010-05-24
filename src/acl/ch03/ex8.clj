(ns acl.ch03.ex8)

;; dot notation and conses are specific to Lisp but let us
;; nonetheless implement the function

(defn showdots [col]
  (if-let [elt (first col)]
    (do
      (print "(")
      (printf "%s . " elt)
      (showdots (rest col))
      (print ")"))
    (print "nil")))


(showdots '(a b c)) ;; output (a . (b . (c . nil)))
