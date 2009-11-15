
(defn rotate [m]
  (apply vector (apply map (fn [& args] (apply vector (reverse args))) m)))

(defn rotate-seq [m]
  "rotate vector m, returns a lazy sequence of lazy sequences"
  (apply map (comp reverse vector) m))

(comment

  (= (rotate [[:a :b] [:c :d]]) [[:c :a] [:d :b]])
  (= (into [] (rotate-seq [[:a :b] [:c :d]])) ['(:c :a) '(:d :b)])

  (= (rotate [[:a :b :c] [:d :e :f] [:g :h :i]]) [[:g :d :a] [:h :e :b] [:i :f :c]])
)

