(ns gigasecond
  (:require [clj-time.core :as time]))

(defn from [year month day]
  (let [date (time/date-time year month day)
        gigadate (time/plus date (time/seconds (Math/pow 10 9)))]
    [(time/year gigadate) (time/month gigadate) (time/day gigadate)]))
