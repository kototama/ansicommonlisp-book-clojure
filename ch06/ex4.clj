(use 'clojure.test)

(defn most
  ([col]
     (most identity col))
  ([f col]
     (reduce (fn [acc x]
               (let [max1 (first acc)
                     max2 (second acc)
                     val (f x)]
                 (cond (nil? max1) [val nil]
                       (nil? max2) (if (> val max1) [val max1] [max1 val])
                       (> val max1) [val max1]
                       (> val max2) [max1 val]
                       :else [max1 max2]))) [nil nil] col)))

(deftest most-test
  (is (= [-3 nil] (most [-3])))
  (is (= [42 41] (most [41 42])))
  (is (= [6 5] (most [1 2 3 4 5 6])))
  (is (= [-1 -2] (most [-1 -2 -3 -4 -5 -6]))))

(deftest most-with-func-test
  (letfn [(negate [x] (if (nil? x) nil (- x)))]
    (is (= [3 nil] (most negate [-3])))
    (is (= [-41 -42] (most negate [41 42])))
    (is (= [-1 -2] (most negate [1 2 3 4 5 6])))
    (is (= [6 5] (most negate [-1 -2 -3 -4 -5 -6])))))

;; user> (run-tests 'user)

;; Testing user

;; Ran 1 tests containing 2 assertions.
;; 0 failures, 0 errors.
;; {:type :summary, :test 1, :pass 2, :fail 0, :error 0}
