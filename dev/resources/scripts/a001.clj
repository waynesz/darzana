(control/defroute "pet" :get
  (mapper/read-value {:from :params} {:var :pet :type io.swagger.model.Pet})
  (api/call-api {:id :petshop :path "/pet" :method :post})
  (renderer/render {:template "/petstore/updated"}))
