(ns darzana.command.api-test
  (:require [integrant.core :as ig]
            [darzana.api-spec.swagger :as swagger]
            [darzana.http-client.okhttp :as okhttp]
            [darzana.runtime :as runtime]
            [darzana.command.api :as sut]
            [clojure.test :refer :all]))

(deftest call-api
  (let [config  {:darzana.api-spec/swagger {:swagger-path "dev/resources/darzana"}
                 :darzana/runtime {:routes-path "dev/resources/scripts"
                                   :commands [['darzana.command.api :as 'api]
                                              ['darzana.command.control :as 'control]
                                              ['darzana.command.mapper :as 'mapper]
                                              ['darzana.command.renderer :as 'renderer]]}}
        system  (ig/init config)
        runtime (:darzana/runtime system)
        ctx (runtime/create-context runtime {:params {:petId "1"}})
        api {:id "petstore" :path "/pet" :method :post}]
    (println (sut/call-api ctx api))))
