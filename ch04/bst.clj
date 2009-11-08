(use 'clojure.contrib.def)

(declare percolate rperc lperc)

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

;; with tail call
(defn bst-insert-tc [bst x comp]
  (loop [bst bst
         acc '()]
    (if (nil? bst)
      (loop [tree (struct node x)
             stack acc]
        (let [[lr elt branch] (first stack)]
          (if (empty? stack)
            tree
            (if (= lr :l)
              (recur (struct node elt branch tree) (rest stack))
              (recur (struct node elt tree branch) (rest stack))))))
      (let [elt (:elt bst)]
        (if (= x elt)
          bst
          (if (comp x elt)
            (recur (:l bst) (cons [:r elt (:r bst)] acc))
            (recur (:r bst) (cons [:l elt (:l bst)] acc))))))))

(defn bst-insert-tc2 [bst x comp]
  (loop [bst bst
         acc '()]
    (if (nil? bst)
      (reduce (fn [tree [lr elt branch]]
                (if (= lr :l)
                  (struct node elt branch tree)
                  (struct node elt tree branch)))
              (struct node x)
              acc)
      (let [elt (:elt bst)]
        (if (= x elt)
          bst
          (if (comp x elt)
            (recur (:l bst) (cons [:r elt (:r bst)] acc))
            (recur (:r bst) (cons [:l elt (:l bst)] acc))))))))

(defn bst-insert-tc3 [bst x cmp]
  (if (nil? bst)
    (struct node x)
    (loop [bst bst
           f identity]
      (if (nil? bst)
        (f (struct node x))
        (let [elt (:elt bst)]
          (if (= x elt)
            bst
            (if (cmp x elt)
              (recur (:l bst) (comp f (fn [l] (struct-map node :elt elt :r (:r bst) :l l))))
              (recur (:r bst) (comp f (fn [r] (struct-map node :elt elt :l (:l bst) :r r)))))))))))

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

(defn bst-remove [bst x comp]
  (if (nil? bst)
    nil
    (let [elt (:elt bst)]
      (if (= x elt)
        (percolate bst)
        (if (comp x elt)
          (struct node
                  elt
                  (bst-remove (:l bst) x comp)
                  (:r bst))
          (struct node
                  elt
                  (:l bst)
                  (bst-remove (:r bst) x comp)))))))

(defn bst-traverse [bst f]
  (when bst
    (bst-traverse (:l bst) f)
    (f (:elt bst))
    (bst-traverse (:r bst) f)))

(defn- percolate [bst]
  (cond (nil? (:l bst)) (if (nil? (:r bst))
                          nil
                          (rperc bst))
        (nil? (:r bst)) (lperc bst)
        :else (if (zero? (rand-int 2))
                 (lperc bst)
                 (rperc bst))))

(defn- rperc [bst]
  (struct node
          (:elt (:r bst))
          (:l bst)
          (percolate (:r bst))))

(defn- lperc [bst]
  (struct node
          (:elt (:l bst))
          (percolate (:l bst))
          (:r bst)))


(comment

  (def nums (reduce (fn [acc x] (bst-insert acc x <)) nil [5 8 4 2 1 9 6 7 3]))
  (def nums2 (reduce (fn [acc x] (bst-insert-tc acc x <)) nil [5 8 4 2 1 9 6 7 3]))
  (def nums3 (reduce (fn [acc x] (bst-insert-tc2 acc x <)) nil [5 8 4 2 1 9 6 7 3]))
  (def nums4 (reduce (fn [acc x] (bst-insert-tc3 acc x <)) nil [5 8 4 2 1 9 6 7 3]))

  (= nums nums2 nums3 nums4)

  (bst-find nums 12 <) ; nil
  (bst-find nums 4 <) ; {:elt 4, :l {:elt 2, :l {:elt 1, :l nil, :r nil}, :r {:elt 3, :l nil, :r nil}}, :r nil}

  (bst-min nums) ; {:elt 1, :l nil, :r nil}
  (bst-max nums) ; {:elt 9, :l nil, :r nil}

  (bst-traverse (bst-remove nums 2 <) print) ; 13456789

)


