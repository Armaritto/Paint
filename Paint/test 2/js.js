const vueApp = Vue.createApp({
    components: {
        Konva
      },
  
    data(){
      return{
      stage:  new Konva.Stage({container: 'container', width: 500,  height: 500}),
      layer:  new Konva.Layer(),
      pressed:false,
      drawingCircle: false,
      drawingEllipse: false,
    
      drawCircle: function(){ this.stage.add(this.layer)
        this.layer.add(new Konva.Circle({
            x: 250,
            y: 250,
            radius: 70,
            //fill: 'red',
            stroke: 'black',
            strokeWidth: 4,
            draggable:true,
            id: '1'
          }))},
      drawEllipse: function(){
        var oval = new Konva.Ellipse({
        x: 400,
        y: 300,
        radiusX: 100,
        radiusY: 50,
        //fill: 'yellow',
        stroke: 'black',
        strokeWidth: 4,
        draggable:true
      });
      this.layer.add(oval);
      },
      fillShape: false,
      x: 'fill',
      c:'#9933ff',
      buff: "",
      ans: 0,
      op:"",
      obj: {}
  }
  }
    ,methods:{
        init(){
            
           
            

        },
        
        handleCircle(){
            this.drawCircle()
         },
         handleEllipse(){
            this.drawEllipse()
         }
    }
}
)
vueApp.mount("#app")
// layer.add(new Konva.Circle({
//     x: 250,
//     y: 250,
//     radius: 70,
//     //fill: 'red',
//     stroke: 'black',
//     strokeWidth: 4,
//     draggable:true,
//     id: '1'
//   }))