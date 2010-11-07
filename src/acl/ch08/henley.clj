(ns acl.ch08.henley
  (:use clojure.contrib.def
        clojure.contrib.pprint
        [clojure.contrib.duck-streams :only (read-lines
                                             write-lines
                                             reader
                                             writer)])
  (:require [clojure.string :as str]))

(defn internize [s]
  ;; slow?! : (intern 'acl.ch08.henley (symbol s))
  (symbol s))

(defn read-text [pathname]
  (letfn []
   (reduce (fn [stats line]
             (let [line (str/replace line #" +" " ")
                   words (re-seq #"([a-z'àçéêèëùA-Z]+|[.,;!?]+)" line)
                   words (map first words)]
               (reduce (fn [stats word]
                         (let [word (internize word)]
                           (let [prev (:prev stats)]
                             (let [stats (if-let [noccur (get-in stats [prev word])]
                                           (update-in stats [prev word] inc)
                                           (assoc-in stats [prev word] 1))]
                               (assoc stats :prev word)))))
                       stats words)))
           {:prev (internize ".")}
           (read-lines pathname))))

(defn- random-next [stats prev]
  (let [choices (get stats prev)
        i (rand-int (reduce + (map second choices)))]
    (loop [i i
           choices choices]
      (let [[word p] (first choices)
            diff (- i p)]
        (if (neg? diff)
          word
          (recur diff (next choices)))))))

(defn generate-text
  ([n stats]
     (generate-text n stats (internize ".")))
  ([n stats prev]
     (loop [n n
            prev prev]
       (when (pos? n)
         (let [next (random-next stats prev)]
           (printf "%s " next)
           (recur (dec n) next))))
     (println)))

(let [stats (read-text "/home/ktm/Documents/Projects/Clojure/ansicommonlisp-book-clojure/src/acl/ch08/baudelaire.txt")]
  (generate-text 130 stats))