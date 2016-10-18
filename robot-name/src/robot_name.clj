(ns robot-name) 

(defn- gen-name []
  (let [chars (map char (range (int \A) (int \Z)))
        first-letter (rand-nth chars)
        second-letter (rand-nth chars)
        numbers-name (repeat 3 (rand-int 10))
        name (into [first-letter second-letter] numbers-name)]
    (clojure.string/join name)))

(defn robot-name [x]
  (:name @x))

(defn robot []
  (atom {:name (gen-name)}))

(defn reset-name [x]
  (swap! x assoc :name (gen-name)))
