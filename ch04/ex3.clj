(defstruct node :ele :l :m :r)

(defn tree-contains? [t ele]
  (if (nil? t)
    false
    (if (= ele (:ele t))
      true
      (or (tree-contains? (:l t) ele)
          (tree-contains? (:m t) ele)
          (tree-contains? (:r t) ele)))))

(def tree
     (struct node :a 
             (struct node :al1) 
             (struct node :am1 (struct node :al2) (struct node :am2 nil (struct node :am3)) (struct node :ar2))
             (struct node :ar1 nil nil (struct node :ar2))))

(comment
  (= (tree-contains? tree :ar3) false)
  (= (tree-contains? tree :am3) true)
)
