(use 'clojure.test)

(let [lastval (atom nil)]
  (defn greater-than-last? [n]
    (let [prev @lastval]
      (swap! lastval (constantly n))
      (if (not (nil? prev))
        (> n prev)
        false))))

(deftest greater-than-last?-test
  (is (= false (greater-than-last? 42)))
  (is (= true (greater-than-last? 43)))
  (is (= false (greater-than-last? 40)))
  (is (= true (greater-than-last? 41))))
