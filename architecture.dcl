%modules def
module View: bvs.boundery.**
module Control: bvs.controle.**
module Entity: bvs.entity.**
module App: bvs.BeverageStockApp.BeverageStockApp

%rules def
View cannot-access Entity
App must-create Control, View  
