(ns acl.ch04.ex4
  (:use acl.ch04.bst))

(defn bst-list [bst]
  (letfn [(explore
           [tree values]
           (if (nil? tree)
             values
             (concat
              (explore (:r tree) values)
              [(:elt tree)]
              (explore (:l tree) values))))]
    (explore bst [])))

(def nums (reduce (fn [acc x] (bst-insert acc x <)) nil [5 8 4 2 1 9 6 7 3]))

(comment 
  (= (bst-orderedlist nums) '(9 8 7 6 5 4 3 2 1))
)

