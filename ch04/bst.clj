(use 'clojure.contrib.def)

(defstruct node :elt :l :r)

(defn bst-insert [bst x comp]
  (if (nil? bst)
    (struct node x)
    (let [elt (:elt bst)]
      (if (= x elt)
        bst
        (if (comp x elt)
          (struct node
                  elt
                  (bst-insert (:l bst) x comp)
                  (:r bst))
          (struct node
                  elt
                  (:l bst)
                  (bst-insert (:r bst) x comp)))))))

(defn bst-find [bst x comp]
  (if (nil? bst)
    nil
    (let [elt (:elt bst)]
      (if (= x elt)
        bst
        (if (comp x elt)
          (recur (:l bst) x comp)
          (recur (:r bst) x comp))))))

(defn bst-min [bst]
  (and bst
       (or (bst-min (:l bst)) bst)))

(defn bst-max [bst]
  (and bst
       (or (bst-max (:r bst)) bst)))

;;;;
;;;;

(comment

  (def nums (reduce (fn [acc x] (bst-insert acc x <)) nil [5 8 4 2 1 9 6 7 3]))

  (bst-find nums 12 <) ; nil
  (bst-find nums 4 <) ; {:elt 4, :l {:elt 2, :l {:elt 1, :l nil, :r nil}, :r {:elt 3, :l nil, :r nil}}, :r nil}

  (bst-min nums) ; {:elt 1, :l nil, :r nil}
  (bst-max nums) ; {:elt 9, :l nil, :r nil}

)


