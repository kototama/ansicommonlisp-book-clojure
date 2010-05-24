(ns acl.ch05.ex4
  (:use clojure.contrib.def))

(defvar- *month* [0 31 59 90 120 151 181 212 243 273 304 334 365])

(defn- leap? [y]
  (and (zero? (mod y 4))
       (or (zero? (mod y 400))
           (not (zero? (mod y 100))))))

(defn month-num [m y]
  (+ (*month* (dec m))
     (if (and (> m 2) (leap? y)) 1 0)))

(defn month-num2 [m y]
  (+ (condp = m
       1 0
       2 31
       3 59
       4 90
       5 120
       6 151
       7 181
       8 212
       9 243
       10 273
       11 304
       12 334)
     (if (and (> m 2) (leap? y)) 1 0)))
