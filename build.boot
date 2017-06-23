(set-env!
 :source-paths   #{"src/cljs"}
 :resource-paths #{"src/cljs" "resources"}
 :dependencies '[[kioo "0.4.2" :exclusions [org.omcljs/om
                                            cljsjs/react]]])

(task-options!
 push {:repo-map {:url "https://clojars.org/repo/"}}
 pom {:project 'org.danielsz/om-header-bootstrap
      :version "0.1.0-SNAPSHOT"
      :scm {:name "git"
            :url "https://github.com/danielsz/om-header-bootstrap"}})

(deftask build
  []
  (comp (pom) (jar) (install)))

(deftask push-release
  []
  (comp
   (build)
   (push)))
