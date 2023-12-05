
const vueApp = Vue.createApp({

  data(){
    return{
    pressed:false,
    drawCircle: false,
    drawEllipse: false,
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
    drawCircle(){
      var circle = new Konva.Circle({
        x: stage.width() / 2,
        y: stage.height() / 2,
        radius: 70,
        fill: 'red',
        stroke: 'black',
        strokeWidth: 4,
        //draggable:true
      });
      layer.add(circle);
    },
    drawEllipse(){
      var oval = new Konva.Ellipse({
        x: stage.width() / 2,
        y: stage.height() / 2,
        radiusX: 100,
        radiusY: 50,
        fill: 'yellow',
        stroke: 'black',
        strokeWidth: 4,
        //draggable:true
      });
      layer.add(oval);

    },
    handleClick(event){
       var color = this.c


      //console.log(event.pageX)
      if(this.drawCircle == true){

          pressed = true
        var circle = new Konva.Circle({
          x: event.pageX,
          y: event.pageY,
          radius: 70,
          //fill: 'red',
          stroke: 'black',
          strokeWidth: 4,
          draggable:true,
          id: '1'
        });

        //document.getElementById("colorpicker").value
        circle.on('click', function () {

            this.fill(color);
            // console.log(this.x);
            // console.log(color);
            // console.log(this.drawCircle);

        });
        circle.on('click', function () {
          if(this.fillShape == true){
            this.fill(this.c);
            //console.log(this.fillShape);
          }else{
            tr.nodes([circle]);
          }

          //circle.destroy();
        });


        layer.add(circle);
        //tr.nodes.add(circle);
        //setTimeout(() => {circle.destroy()}, 50)
        this.drawCircle = false;



      }
      if(this.drawEllipse == true){
        //stage.find('1')[0];
        var oval = new Konva.Ellipse({
          x: event.pageX,
          y: event.pageY,
          radiusX: 100,
          radiusY: 50,
          //fill: 'yellow',
          stroke: 'black',
          strokeWidth: 4,
          draggable:true
        });
        oval.on('click', function () {
          tr.nodes([oval]);
        });
        layer.add(oval);
        this.drawEllipse = false;

      }

    }


  }
})
vueApp.mount("#app")
const mousePosText = document.getElementById('mouse-pos');
// let mousePos = { x: undefined, y: undefined };

// window.addEventListener('mousemove', (event) => {
//   mousePos = { x: event.clientX, y: event.clientY };
//   mousePosText.textContent = `(${mousePos.x}, ${mousePos.y})`;
// });
var stage = new Konva.Stage({container: 'container', width: 500,  height: 500});
var layer = new Konva.Layer();
stage.add(layer);
var tr = new Konva.Transformer();
layer.add(tr);

// by default select all shapes

// add a new feature, lets add ability to draw selection rectangle
// var selectionRectangle = new Konva.Rect({
//   fill: 'rgba(0,0,255,0.5)',
//   visible: false,
// });
// layer.add(selectionRectangle);
//
// var x1, y1, x2, y2;
// stage.on('mousedown touchstart', (e) => {
//   // do nothing if we mousedown on any shape
//   if (e.target !== stage) {
//     return;
//   }
//   e.evt.preventDefault();
//   x1 = stage.getPointerPosition().x;
//   y1 = stage.getPointerPosition().y;
//   x2 = stage.getPointerPosition().x;
//   y2 = stage.getPointerPosition().y;
//
//   selectionRectangle.visible(true);
//   selectionRectangle.width(0);
//   selectionRectangle.height(0);
// });
//
// stage.on('mousemove touchmove', (e) => {
//   // do nothing if we didn't start selection
//   if (!selectionRectangle.visible()) {
//     return;
//   }
//   e.evt.preventDefault();
//   x2 = stage.getPointerPosition().x;
//   y2 = stage.getPointerPosition().y;
//
//   selectionRectangle.setAttrs({
//     x: Math.min(x1, x2),
//     y: Math.min(y1, y2),
//     width: Math.abs(x2 - x1),
//     height: Math.abs(y2 - y1),
//   });
// });

// stage.on('mouseup touchend', (e) => {
//   // do nothing if we didn't start selection
//   if (!selectionRectangle.visible()) {
//     return;
//   }
//   e.evt.preventDefault();
//   // update visibility in timeout, so we can check it in click event
//   setTimeout(() => {
//     selectionRectangle.visible(false);
//   });
//
//   var shapes = stage.find('.rect');
//   var box = selectionRectangle.getClientRect();
//   var selected = shapes.filter((shape) =>
//     Konva.Util.haveIntersection(box, shape.getClientRect())
//   );
//   tr.nodes(selected);
// });
//
// // clicks should select/deselect shapes
// stage.on('click tap', function (e) {
//   // if we are selecting with rect, do nothing
//   if (selectionRectangle.visible()) {
//     return;
//   }
//
//   // if click on empty area - remove all selections
//   if (e.target === stage) {
//     tr.nodes([]);
//     return;
//   }
//
//   // do nothing if clicked NOT on our rectangles
//   if (!e.target.hasName('rect')) {
//     return;
//   }
//
//   // do we pressed shift or ctrl?
//   const metaPressed = e.evt.shiftKey || e.evt.ctrlKey || e.evt.metaKey;
//   const isSelected = tr.nodes().indexOf(e.target) >= 0;
//
//   if (!metaPressed && !isSelected) {
//     // if no key pressed and the node is not selected
//     // select just one
//     tr.nodes([e.target]);
//   } else if (metaPressed && isSelected) {
//     // if we pressed keys and node was selected
//     // we need to remove it from selection:
//     const nodes = tr.nodes().slice(); // use slice to have new copy of array
//     // remove node from array
//     nodes.splice(nodes.indexOf(e.target), 1);
//     tr.nodes(nodes);
//   } else if (metaPressed && !isSelected) {
//     // add the node into selection
//     const nodes = tr.nodes().concat([e.target]);
//     tr.nodes(nodes);
//   }
// });





// stage.on('click', function(e){
//   var id = e.target.id();
//   e.target.fill();
//   console.log(id);
//
// });




