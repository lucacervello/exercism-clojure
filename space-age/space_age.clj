(ns space-age)

(def earth-year-in-seconds 31557600)

(def planet-year-in-seconds {:earth earth-year-in-seconds
                             :mercury (* earth-year-in-seconds 0.2408467)
                             :venus (* earth-year-in-seconds 0.61519726)
                             :mars (* earth-year-in-seconds 1.8808158)
                             :jupiter (* earth-year-in-seconds 11.862616)
                             :saturn (* earth-year-in-seconds 29.447498)
                             :uranus (* earth-year-in-seconds 84.016846)
                             :neptune (* earth-year-in-seconds 164.79132)})

(defn planet-years [planet-ks seconds]
  (/ seconds (planet-ks planet-year-in-seconds)))

(defn on-earth [seconds]
  (planet-years :earth seconds))

(defn on-mercury [seconds]
  (planet-years :mercury seconds))

(defn on-venus [seconds]
  (planet-years :venus seconds))

(defn on-mars [seconds]
  (planet-years :mars seconds))

(defn on-jupiter [seconds]
  (planet-years :jupiter seconds))

(defn on-saturn [seconds]
  (planet-years :saturn seconds))

(defn on-uranus [seconds]
  (planet-years :uranus seconds))

(defn on-neptune [seconds]
  (planet-years :neptune seconds))
