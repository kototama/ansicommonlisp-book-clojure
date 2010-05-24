(ns acl.ch05.ex2)

(defn mystery [x y] 
  "Return the first position of the element x in the list, 
  or nil it does not exist"
  (if (empty? y)	
    nil
    (if (= (first y) x)
      0
      (let [z (mystery x (rest y))]
        (and z (+ z 1))))))

(defn mystery2 [x y]
  "Return the first position of the element x in the list, 
  or nil it does not exist"
  (cond (empty? y) nil
        (= (first y) x) 0
        :else (let [z (mystery2 x (rest y))]
                (and z (+ z 1)))))


(= (mystery2 :a [:b :c :d :a :e]) (mystery :a [:b :c :d :a :e]))
(= (mystery2 :a  [:b :c :d :e :e]) (mystery :a [:b :c :d :e :e]))


