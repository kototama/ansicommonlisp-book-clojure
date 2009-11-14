
(defn rotate [m]
  (apply vector (apply map (fn [& args] (apply vector (reverse args))) m)))


(comment

  (= (rotate [[:a :b] [:c :d]]) [[:c :a] [:d :b]])
  
  (= (rotate [[:a :b :c] [:d :e :f] [:g :h :i]]) [[:g :d :a] [:h :e :b] [:i :f :c]])
)

