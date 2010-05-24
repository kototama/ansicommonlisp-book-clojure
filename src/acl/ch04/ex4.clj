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
