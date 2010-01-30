(use 'clojure.contrib.def)
(use 'clojure.contrib.import-static)

(import-static java.lang.Math ceil)

(declare finder round)


(defn bincontains?
  ([coll x]
     (bincontains? coll x {:key identity :test = :start 0}))
  ([coll x {:keys [key test start end] :or {key identity test = start 0}} ]
     (if (not (vector? coll))
       ;; in this case, better perform a linear search
       (throw (Exception. "Invalid collection type")))
     (let [len (count coll)]
       (and (not (zero? len))
            (if (nil? end)
              (finder coll x {:key key :test test :start start :end (dec len)})
              (finder coll x {:key key :test test :start start :end end}))))))

;; Round in Lisp rounds to the nearest even digit.
;; In Java round is equivalent to (int)Math.floor(a + 0.5f)
;;
;; What we really need in the context of this algorithm
;; is a round that returns 0 when passed 0.5
;;
(defn- round [x]
  (int (ceil (- x 0.5))))

(defn- finder [vec x {:keys [key test start end]}]
  (let [rng (- end start)]
    (if (zero? rng)
      (test x (key (get vec start)))
      (let [mid (+ start (round (double (/ rng 2))))
            y (key (get vec mid))]
        ;; (printf "rng = %s mid = %s s = %s e = %s y = %s\n\n", rng mid start end y)
        (if (< x y)
          (recur vec x {:key key :test test :start start :end (dec mid)})
          (if (> x y)
            (recur vec x {:key key :test test :start (inc mid) :end end})
            true))))))
  
(comment

  (bincontains? [1 2 3 4 5 6] 9) ;; false
  (bincontains? [0 1 2 3 4 5 6 7 8 9] 6) ;; true
  (bincontains? [ [0 :zero] [1 :one] [2 :two] [3 :three] [4 :four] [5 :five] [6 :six] [7 :seven] [8 :eight] [9 :nine]] 6 {:test = :key first :start 0 :end 9} ) ;; true
)