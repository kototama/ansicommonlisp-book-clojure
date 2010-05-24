(ns acl.ch03.ex9
 (:use clojure.contrib.def))

(declare dfs)

(defn longest-path [start end net]
  "Return a list containing the longest path between start and end"
  "or an empty list if there is no path"
  (reverse (last (sort-by count (dfs net end [start] [] [])))))

(defn- dfs [net end [node :as path] allpaths tovisit]
  ;; this algorithm is fun and terminal recursive but not efficient.
  ;; an efficient algorithm for shortest / longest path is
  ;; the Dijkstra's algorithm
  ;; see http://inclojurewetrust.blogspot.com/2009/10/dijkstra-in-clojure.html

  "Depth-first search with tail recursion. Return all possible paths that go 
   to element end"
  ;; node is the current explored node
  ;; path is the current path leading to the node
  ;; allpaths is the list of path leading to end and starting from start
  ;; tovisit is a queue of nodes that need to be explored
  ;; each node in tovisit is followed by its parent
  (letfn [(member [x seq]
		  "return true if x belongs to seq"
	      (some #(= x %) seq))
  	  
	  (next-path
           [[nextnode parent-nextnode]]
           "construct the path variable for the next recursion"
           (cons nextnode (drop-while #(not= % parent-nextnode) path)))

	  (next-allpaths
           []
           "add the current path to the list of allpaths"
           (conj allpaths path))

	  (next-tovisit
           ([]
              "drop already visited nodes from the queue until a non-visited 
               node is found"
              (dropwhile-visited tovisit))
           ([children]
              "add children (except the first one on which we do the recursion) 
               to the queue"
              (concat (interleave (rest children) (repeat node)) tovisit)))

	  (dropwhile-visited
           [col]
           "drop nodes until a non-visited node is found"
           (drop-while #(member % path) col))

	  (next-children
           []
           "drop nodes from the children, until a non-visited child is found"
           (let [children (net node)]
             (dropwhile-visited children)))]

    (if (= node end) 
      (if (empty? tovisit)
	(next-allpaths)
	(recur net end (next-path tovisit) (next-allpaths) (drop 2 tovisit)))
      (let [children (next-children)
	    child (first children)]
	(if (nil? child)
	  (let [nexttovisit (next-tovisit)]
	    (if (empty? nexttovisit)
	      allpaths
	      (recur net end (next-path nexttovisit) allpaths
                     (drop 2 nexttovisit))))
	  (recur net end (cons child path) allpaths
                 (next-tovisit children)))))))
