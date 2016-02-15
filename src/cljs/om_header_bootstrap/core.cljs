(ns om-header-bootstrap.core
  (:require
   [om.core :as om :include-macros true]
   [kioo.om :refer [content set-attr do-> substitute listen add-class set-class]])
  (:require-macros 
   [kioo.om :refer [defsnippet deftemplate]]))

(defsnippet fn-nav-item "templates/header.html" [:li]
  [[caption fn]]
  {[:a] (do-> (content caption)
              (listen :onClick fn))})

(defsnippet html-nav-item "templates/header.html" [:li]
  [snippet]
  {[:a] (substitute snippet)})

(defsnippet my-brand "templates/header.html" [:.navbar-header]
  [[caption fn]]
  {[:a] (do-> (content caption)
              (listen :onClick fn))})

(defsnippet header "templates/header.html" [:nav]
  [data owner opts]
  {[:.navbar-header] (content (my-brand (:brand opts)))
   [:.navbar-left] (content (map fn-nav-item (:left opts)))
   [:.navbar-right] (content (map html-nav-item ((om/get-state owner :session) opts)))})
