(defproject cues "0.1.0-SNAPSHOT"
  :description "Experimenting with Clojure and Queues"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [com.novemberain/langohr "3.0.0-rc4"]]
  :main ^:skip-aot cues.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
