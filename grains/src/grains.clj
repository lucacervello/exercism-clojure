(ns grains
  (:require [clojure.math.numeric-tower :refer [expt]]))


(defn square [n]
  (expt 2 (dec n)))

(defn total []
  (reduce + (pmap square (range 1 65))))
