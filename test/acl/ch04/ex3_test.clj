(ns acl.ch04.ex3-test
  (:use clojure.test
        acl.ch04.ex3))

(deftest test-tree-contains?
  (let [tree
        (struct node :a 
                (struct node :al1) 
                (struct node :am1 (struct node :al2) (struct node :am2 nil
                                                             (struct node :am3))
                        (struct node :ar2))
                (struct node :ar1 nil nil (struct node :ar2)))]
    (is (not (tree-contains? tree :ar3)))
    (is (tree-contains? tree :am3))))


