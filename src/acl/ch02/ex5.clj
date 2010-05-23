(ns acl.ch02.ex5)

;; The main difference with the Lisp version is :
;; in Clojure (nil? '()) is false
;; whereas in Lisp (null '()) is true
;; This is because of the equivalence empty list <=> nil in Lisp
(defn enigma [x]
  "Return true if an element of the list x is nil, false otherwise"
  (and (not (empty? x))
       (or (nil? (first x))
	   (recur (rest x)))))

(defn mystery [x y] 
  "Return the first position of the element x in the list, 
  or nil it does not exist"
  (if (empty? y)	
      nil
      (if (= (first y) x)
	  0
	  (let [z (mystery x (rest y))]
	    (and z (+ z 1))))))


(enigma '(a nil c)) ;; true
(enigma '(a d c)) ;; false
(enigma '(a (a nil) c)) ;; false

(mystery 'a '( b c d a e)) ;; 3
(mystery 'a '( b c d e e)) ;; nil
