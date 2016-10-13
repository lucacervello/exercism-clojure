(ns grade-school)

(defn add [db name grade]
  (update-in db [grade] #(conj (vec %) name)))

(defn grade [db grade]
  (get db grade []))

(defn sorted [db]
  (let [sort-map (into (sorted-map) db)]
    (into (sorted-map)(zipmap (keys sort-map)
                              (mapv sort (vals sort-map))))))
