(ns acl.ch05.ex9
 (:use clojure.contrib.def)
 (:import acl.ch05.ex9.PathFoundException))

(declare bfs new-paths)

(defn shortest-path [start end net]
  (try
   (bfs end (list (list start)) net)
   (catch PathFoundException e (.getPath e))))

(defn- bfs [end queue net]
  (if (empty? queue)
    nil
    (let [path (first queue)
	  node (first path)]
      (if (= node end)
	(throw (PathFoundException. (reverse path)))
	(recur end
	       (concat (rest queue)
		       (new-paths path node net))
	       net)))))

(defn- new-paths [path node net]
  (map #(cons % path) (net node)))
