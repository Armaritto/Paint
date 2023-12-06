<template>
  <body>
    <div>
    <table>
      <tr>
        <td>
          <div class="playground">
  <v-stage @click="handleClick" @mousedown="handleStageMouseDown" @touchstart="handleStageMouseDown" ref="stage" :config="configKonva">
    <v-layer  @wheel= "(event) =>{
        if(this.booleans.resizing){event.target.attrs.radius = Math.max(event.target.attrs.radius-Number(event.evt.deltaY)/20, 5);
          //layer.circles.pop();
        }
         //this.$forceUpdate();
         }"
              @click="(event)=>{
          console.log('clicked')
          if(this.booleans.filling){
            event.target.attrs.fill = this.c
            var id = Number(event.target.attrs.id)
            //changeFill(event.target.attrs,this.c)
          }
          else if(this.booleans.deleting){
            var id = Number(event.target.attrs.id)
            this.deleteShape(id)
          }
         }"
              ref="layer">
      <!-- <v-transformer>
        <v-circle :config="{
        x: 200,
        y: 100,.scale.x += event.deltaY/100
        radius: 50,   event.target.attrs.scale.x += event.deltaY/100
        fill: 'green'
      }"v-if="shapeConfig!==undefined"
       @transformend="handleTransformEnd" @dragend="handleDragEnd"
    />
      </v-transformer> -->
      <v-circle v-for="circle in this.layer.circles" :config="circle" @transformend="handleTransformEndCircle"></v-circle>
      <v-ellipse v-for="ellipse in this.layer.ellipses" :config="ellipse" @transformend="handleTransformEndEllipse"></v-ellipse>
      <v-rect v-for="rect in this.layer.rects" :config="rect" @transformend="handleTransformEndRect"></v-rect>
      <v-rect v-for="square in this.layer.squares" :config="square" @transformend="handleTransformEndSquare"></v-rect>
      <v-line v-for="line in this.layer.lines" :config="line" @transformend="handleTransformEndLine"></v-line>
      <v-regular-polygon v-for="shapeConfig in this.layer.triangles" :key="shapeConfig" class="shapeconfig"
                         :config="shapeConfig" @transformend="handleTransformEndTriangle"></v-regular-polygon>
      <v-transformer ref="transformer" />
    </v-layer>
  </v-stage>
  </div>
  </td>
  <td>
    <div class="button-container" style="background: #083556;">
      <table>
        <tr>
          <button class="blue-button" @click="refreshBooleans(); this.booleans.drawingLine = !this.booleans.drawingLine">
            <lord-icon
                src="https://cdn.lordicon.com/dykoqszm.json"
                trigger="hover"
                colors="primary:#083556,secondary:#ffffff"
                style="width:70px;height:70px">
            </lord-icon>
          </button>
        </tr>
        <tr>
          <button class="blue-button" @click="refreshBooleans(); this.booleans.drawingTriangle = !this.booleans.drawingTriangle">
            <lord-icon
                src="https://cdn.lordicon.com/qluhlwas.json"
                trigger="hover"
                colors="primary:#ffffff,secondary:#ffffff"
                style="width:50px;height:50px">
            </lord-icon>
          </button>
        </tr>
        <tr>
          <button class="blue-button" @click="refreshBooleans(); this.booleans.drawingCircle = !this.booleans.drawingCircle">
            <lord-icon
                src="https://cdn.lordicon.com/jeycryzx.json"
                trigger="hover"
                colors="primary:#ffffff,secondary:#ffffff"
                style="width:50px;height:50px">
            </lord-icon>
          </button>
        </tr>
        <tr>
          <button class="blue-button" @click="refreshBooleans(); this.booleans.drawingSquare = !this.booleans.drawingSquare">
            <lord-icon
                src="https://cdn.lordicon.com/vasuakrs.json"
                trigger="hover"
                colors="primary:#ffffff,secondary:#ffffff"
                style="width:50px;height:50px">
            </lord-icon>
          </button>
        </tr>
        <tr>
          <button class="blue-button" @click="refreshBooleans(); this.booleans.drawingEllipse = !this.booleans.drawingEllipse">
            <lord-icon
                src="https://cdn.lordicon.com/cdzmvgnm.json"
                trigger="hover"
                colors="primary:#ffffff,secondary:#ffffff"
                style="width:50px;height:50px">
            </lord-icon>
          </button>
        </tr>
        <tr>
          <button class="blue-button" @click="refreshBooleans(); this.booleans.drawingRectangle = !this.booleans.drawingRectangle">
            <lord-icon
                src="https://cdn.lordicon.com/maetoptg.json"
                trigger="hover"
                colors="primary:#ffffff,secondary:#ffffff"
                style="width:50px;height:50px">
            </lord-icon>
          </button>
        </tr>
        <tr>
          <button class="blue-button" @click="refreshBooleans(); this.booleans.filling = !this.booleans.filling">
            <lord-icon
                src="https://cdn.lordicon.com/wuvorxbv.json"
                trigger="hover"
                colors="primary:#ffffff,secondary:#ffffff"
                style="width:50px;height:50px">
            </lord-icon>
          </button>
          <div v-if= this.booleans.filling>
            <input v-model="c" type="color" id="colorpicker" value="#ffff33">
          </div>
          <div v-else style="margin-bottom: 9px; color: #083556">
            .
          </div>
        </tr>
        <tr>
          <button class="blue-button" @click="refreshBooleans(); this.booleans.deleting = !this.booleans.deleting">
            <lord-icon
                src="https://cdn.lordicon.com/drxwpfop.json"
                trigger="hover"
                colors="primary:#ffffff,secondary:#ffffff"
                style="width:50px;height:50px">
            </lord-icon>
          </button>
        </tr>
        <tr>
          <button class="blue-button" @click="refreshBooleans(); undo();">↶</button>
        </tr>
        <tr>
          <button  class="blue-button" @click="refreshBooleans(); redo();">↷</button>
        </tr>
        <tr>
          <button class="blue-button" @click="refreshBooleans() ; saveJOSNFile();">save JSON</button>
        </tr>
        <tr>
          <button class="blue-button" @click="refreshBooleans() ; saveXMLFile();">save XML</button>
        </tr>
        <tr>
          <button class="blue-button" @click="refreshBooleans() ; loadJSONFile();">load JSON</button>
        </tr>
        <tr>
          <button class="blue-button" @click="refreshBooleans() ; loadXMLFile();">load XML</button>
        </tr>

      </table>

    </div>
  </td>
  </tr>
  </table>
  </div>
  </body>
</template>






<!--            <button @click="refreshBooleans(); this.booleans.moving = !this.booleans.moving">move {{this.booleans.moving}}</button>-->
<!--            <button @click="refreshBooleans(); this.booleans.resizing = !this.booleans.resizing">resize {{this.booleans.resizing}}</button>-->






<style>

.button-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
.blue-button {
  display: flex;
  justify-content: center;
  background-color: #083556;
  color: white;
  border: none;
  border-radius: 0;
  padding: 10px 20px;
  margin: 0;
  cursor: pointer;
  transition: background-color 0.3s;
  margin-bottom: -2px;
}

.blue-button:hover {
  background-color: #022338;
}
</style>


<script>
import lottie from "lottie-web";
import { defineElement } from "@lordicon/element";

// define "lord-icon" custom element with default properties
defineElement(lottie.loadAnimation);
import Konva from "konva";
const width = window.innerWidth * 0.9;
const height = window.innerHeight * 0.95;
export default {
  data() {
    return {
      c:'#9933ff',

      // changeFill: function (shape, fill) {
      //   console.log(shape)
      //   fetch('http://localhost:8080/edit?' + new URLSearchParams({
      //     id: Number(shape.id),
      //     type: shape.type,
      //     fill: fill,
      //     x: event.pageX,
      //     y: event.pageY,
      //     var1: 50,
      //     var2: 0,
      //     rotationAngle: 0
      //   }),
      //       {
      //         method: 'POST'
      //       })
      //       .then(function (response) {
      //         return response.json()
      //       })
      //       .then((data) => {
      //         this.parseArrayList(data)
      //       })
      // },
      saveJSON: function(Path){
          fetch('http://localhost:8080/saveJSON?' + new URLSearchParams({
            path: Path
          }),
              {
                method: 'POST'
              })
      },
      saveXML: function(Path){
        fetch('http://localhost:8080/saveXML?' + new URLSearchParams({
          path: Path
        }),
            {
              method: 'POST'
            })
      },
      loadJSON: function(Path){
        fetch('http://localhost:8080/loadJSON?' + new URLSearchParams({
          path: Path
        }),
            {
              method: 'POST'
            })
            .then(function (response) {
              return response.json()
            })
            .then((data) => {
              this.parseArrayList(data)
            })
      },
      loadXML: function(Path){
        fetch('http://localhost:8080/loadXML?' + new URLSearchParams({
          path: Path
        }),
            {
              method: 'POST'
            })
            .then(function (response) {
              return response.json()
            })
            .then((data) => {
              this.parseArrayList(data)
            })
      },
      undo: function (){
        try{
          fetch('http://localhost:8080/undo?',{method: 'POST'})
              .then(function (response) {
                return response.json()
              })
              .then((data) => {
                this.parseArrayList(data)
              })
        }
        catch(err){
          console.log("error")
        }
      },
      redo: function (){
        try{
          fetch('http://localhost:8080/redo?',{method: 'POST'})
              .then(function (response) {

                return response.json()
              })
              .then((data) => {
                this.parseArrayList(data)
              })
        }
        catch(err){
          console.log("error")
        }
      },
      deleteShape:function(ID){
        fetch('http://localhost:8080/delete?' + new URLSearchParams({
          id: Number(ID),
        }),{method: 'POST'})
              .then(function (response) {
                return response.json()
              })
              .then((data) => {
                this.parseArrayList(data)
              })
      },
      // clear: function(){
      //   this.layer.circles = [];
      //   this.layer.squares = [];
      //   this.layer.triangles = [];
      //   this.layer.lines = [];
      //   this.layer.rects = [];
      //   this.layer.ellipses = [];
      //   fetch('http://localhost:8080/clear?',{method: 'POST'})
      //       .then(function (response) {
      //         return response.json()
      //       })
      //       .then((data) => {
      //         this.parseArrayList(data)
      //       })
      //   console.log(this.layer)
      // },
      edit: function(ID,TYPE,FILL,X,Y,VAR1,VAR2,ROTATIONANGLE,SCALEX,SCALEY){
        console.log(FILL)
        fetch('http://localhost:8080/edit?' + new URLSearchParams({
          id: Number(ID),
          type: TYPE,
          fill: FILL,
          x: X,
          y: Y,
          var1: VAR1,
          var2: VAR2,
          rotationAngle: ROTATIONANGLE,
          ScaleX: SCALEX,
          ScaleY: SCALEY
        }),
            {
              method: 'POST'
            })
      },
      parseArrayList: function(ArrayList){
          this.layer.circles = [];
          this.layer.squares = [];
          this.layer.triangles = [];
          this.layer.lines = [];
          this.layer.rects = [];
          this.layer.ellipses = [];

          for(var i in ArrayList){
            var shape= ArrayList[i];
            if(shape.fill === 'null'){
              shape.fill = null
            }
          if(shape.type === "circle"){
            this.layer.circles.push({
              type: "circle",
              scaleX: shape.scaleX,
              scaleY: shape.scaleY,
              id: shape.id.toString(),
              x: shape.x,
              y: shape.y,
              radius: shape.var1,
              fill: shape.fill,
              stroke: 'black',
              strokeWidth: 1,
              rotation: shape.rotationAngle,
              draggable: true
            })
            console.log(this.layer.circles)
          }
          else if(shape.type === "rectangle"){
            this.layer.rects.push({
              type: "rectangle",
              scaleX: shape.scaleX,
              scaleY: shape.scaleY,
              x: shape.x,
              id: shape.id.toString(),
              y: shape.y,
              width: shape.var2,
              height: shape.var1,
              fill: shape.fill,
              stroke: 'black',
              strokeWidth: 1,
              rotation: shape.rotationAngle,
              draggable: true
            })
          }
          else if(shape.type === "triangle"){
            this.layer.triangles.push({
              type: "triangle",
              scaleX: shape.scaleX,
              scaleY: shape.scaleY,
              id: shape.id.toString(),
              x: shape.x,
              y: shape.y,
              radius: shape.var1,
              sides: shape.var2,
              fill: shape.fill,
              stroke: 'black',
              strokeWidth: 1,
              rotation: shape.rotationAngle,
              draggable: true
            })
          }
          else if(shape.type === "square"){
            this.layer.squares.push({
              type: "square",
              scaleX: shape.scaleX,
              scaleY: shape.scaleY,
              x: shape.x,
              id: shape.id.toString(),
              y: shape.y,
              width: shape.var2,
              height: shape.var1,
              fill: shape.fill,
              stroke: 'black',
              strokeWidth: 1,
              rotation: shape.rotationAngle,
              draggable: true
            })
          }
          else if(shape.type === "ellipse"){
            this.layer.ellipses.push({
              type: "ellipse",
              scaleX: shape.scaleX,
              scaleY: shape.scaleY,
              x: shape.x,
              y: shape.y,
              id: shape.id.toString(),
              radiusX: shape.var1,
              radiusY: shape.var2,
              fill: shape.fill,
              stroke: 'black',
              strokeWidth: 1,
              rotation: shape.rotationAngle,
              draggable: true
            })
          }
          else if(shape.type === "line"){
            this.layer.lines.push({
              type: "line",
              scaleX: shape.scaleX,
              scaleY: shape.scaleY,
              offsetX: 0,
              offsetY: 0,
              lineJoin: 'round',
              id: shape.id.toString(),
              x: shape.x,
              y: shape.y,
              points: [0, 0, shape.var1, shape.var2],
              stroke: 'black',
              strokeWidth:3,
              tension: 0,
              rotation: shape.rotationAngle,
              draggable: true
            })
          }
          else{
            console.log("debug and see why i am here")
          }
        }
      },
      handle: function() {
      if (this.booleans.drawingCircle == true) {
        fetch('http://localhost:8080/newShape?' + new URLSearchParams({
          id: this.generateId(),
          type: "circle",
          fill: null,
          x: event.pageX-17,
          y: event.pageY-10,
          var1: 50,
          var2: 0,
          rotationAngle: 0,
          ScaleX: 1,
          ScaleY: 1
        }),
            {
              method: 'POST'
            })
            .then(function(response){
              return response.json()})
            .then((data) =>{
              this.parseArrayList(data)
            })
        this.booleans.drawingCircle = false;
      }
      else if (this.booleans.drawingSquare == true) {
        fetch('http://localhost:8080/newShape?' + new URLSearchParams({
          id: this.generateId(),
          type: "square",
          fill: null,
          x: event.pageX-17,
          y: event.pageY-10,
          var1: 100,
          var2: 100,
          rotationAngle: 0,
          ScaleX: 1,
          ScaleY: 1
        }),
            {
              method: 'POST'
            })
            .then(function(response){
              return response.json()})
            .then((data) =>{
              this.parseArrayList(data)
            })
        this.booleans.drawingSquare = false;
      }
      else if (this.booleans.drawingRectangle == true) {
        fetch('http://localhost:8080/newShape?' + new URLSearchParams({
          id: this.generateId(),
          type: "rectangle",
          fill: null,
          x: event.pageX-17,
          y: event.pageY-10,
          var1: 100,
          var2: 150,
          rotationAngle: 0,
          ScaleX: 1,
          ScaleY: 1
        }),
            {
              method: 'POST'
            })
            .then(function(response){
              return response.json()})
            .then((data) =>{
              this.parseArrayList(data)
            })
        this.booleans.drawingRectangle = false;
      }
      else if (this.booleans.drawingEllipse == true) {
        fetch('http://localhost:8080/newShape?' + new URLSearchParams({
          id: this.generateId(),
          type: "ellipse",
          fill: null,
          x: event.pageX-17,
          y: event.pageY-10,
          var1: 100,
          var2: 150,
          rotationAngle: 0,
          ScaleX: 1,
          ScaleY: 1
        }),
            {
              method: 'POST'
            })
            .then(function(response){
              return response.json()})
            .then((data) =>{
              this.parseArrayList(data)
            })
        this.booleans.drawingEllipse = false;
      }
      else if (this.booleans.drawingLine == true) {
        fetch('http://localhost:8080/newShape?' + new URLSearchParams({
          id: this.generateId(),
          type: "line",
          fill: null,
          x: event.pageX-17,
          y: event.pageY-10,
          var1: 100,
          var2: 100,
          rotationAngle: 0,
          ScaleX: 1,
          ScaleY: 1
        }),
            {
              method: 'POST'
            })
            .then(function(response){
              return response.json()})
            .then((data) =>{
              this.parseArrayList(data)
            })
        this.booleans.drawingLine = false;
      }
      else if (this.booleans.drawingTriangle == true) {
        fetch('http://localhost:8080/newShape?' + new URLSearchParams({
          id: this.generateId(),
          type: "triangle",
          fill: null,
          x: event.pageX-17,
          y: event.pageY-10,
          var1: 100,
          var2: 3,
          rotationAngle: 0,
          ScaleX: 1,
          ScaleY: 1
        }),
            {
              method: 'POST'
            })
            .then(function(response){
              return response.json()})
            .then((data) =>{
              this.parseArrayList(data)
            })
        this.booleans.drawingTriangle = false;
      }
      else if (this.booleans.moving == true) {

      }
    },
      generateId: function(){return Math.floor(Math.random()*1000000)},
      booleans:{
      drawingCircle: false,
      drawingEllipse: false,
      drawingSquare: false,
      drawingRectangle: false,
      drawingLine: false,
      drawingTriangle: false,
      resizing: false,
      moving: false,
      filling: false,
        deleting: false
    },
      configKonva: {
        width: width,
        height: height,
      },
      configRect: {
        scaleX: 1,
        scaleY: 1,
        rotation: 0,
        x: 250,
        y: 250,
        width: 162,
        height: 100,
        stroke: 'black',
        fill: null,
        strokeWidth: 1,
        draggable: true,
      },
      configSquare: {
        scaleX: 1,
        scaleY: 1,
        rotation: 0,
        x: 250,
        y: 250,
        width: 100,
        height: 100,
        stroke: 'black',
        fill: null,
        strokeWidth: 1,
        draggable: true
      },
      configCircle: {
        scaleX: 1,
        scaleY: 1,
        rotation: 0,
        x: 250,
        y: 250,
        radius: 50,
        fill: null,
        stroke: 'black',
        strokeWidth: 1,
        draggable: true
      },
      configEllipse: {
        scaleX: 1,
        scaleY: 1,
        rotation: 0,
        x: 250,
        y: 250,
        radiusX: 100,
        radiusY: 50,
        fill: null,
        stroke: 'black',
        strokeWidth: 1,
        draggable: true
      },
      configTriangle: {
        scaleX: 1,
        scaleY: 1,
        sides:3,
        x: 250,
        y: 250,
        radius: 50,
        fill: null,
        stroke: 'black',
        strokeWidth: 1,
        draggable: true
      },
      configLine: {
        scaleX: 1,
        scaleY: 1,
        rotation: 0,
        offsetX: 0,
        offsetY: 0,
        lineJoin: 'round',
        x: 0,
        y: 0,
        points: [0, 0, 100, 100],
        stroke: 'black',
        strokeWidth:3,
        tension: 0,
        draggable: true
      },
      layer:{
        circles: [],
        rects: [],
        squares: [],
        ellipses: [],
        triangles: [],
        lines:[]
      },
      //dragItemId: null,

    };
  },
  methods: {
    handleClick(){
      this.handle()
      // for(var k in this.layer.circles)
      // k.addEventListener("wheel", (event) => {this.layer.circles[k].scale.x *= event.deltaY})
    },
    handleTransformEndRect(e) {
      // shape is transformed, let us save new attrs back to the node
      // find element in our state
      const rect = this.layer.rects.find(
          (r) => r.id === this.selectedShapeName
      );
      // update the state
      rect.x = e.target.x();
      rect.y = e.target.y();
      rect.rotation = e.target.rotation();
      rect.scaleX = e.target.scaleX();
      rect.scaleY = e.target.scaleY();
      rect.fill = e.target.fill();
      console.log(rect.scaleX)
      this.edit(rect.id,rect.type,rect.fill,rect.x,rect.y,rect.height,rect.width,rect.rotation,rect.scaleX,rect.scaleY)
    },
    handleStageMouseDown(e) {
      // clicked on stage - clear selection
      console.log(e.target.attrs.type)
      if (e.target === e.target.getStage()) {
        this.selectedShapeName = '';
        this.updateTransformer();
        return;
      }
      // clicked on transformer - do nothing
      const clickedOnTransformer =
          e.target.getParent().className === 'Transformer';
      if (clickedOnTransformer) {
        return;
      }

      // find clicked rect by its name
      const id = e.target.id();
      switch (e.target.attrs.type){
        case "rectangle" :
          const rect = this.layer.rects.find((r) => r.id === id);
          if (rect) {
            this.selectedShapeName = id;
          } else {
            this.selectedShapeName = '';
          }
          break;
        case "triangle" :
          const triangle = this.layer.triangles.find((r) => r.id === id);
          if (triangle) {
            this.selectedShapeName = id;
          } else {
            this.selectedShapeName = '';
          }
          break;
        case "square" :
          const square = this.layer.squares.find((r) => r.id === id);
          if (square) {
            this.selectedShapeName = id;
          } else {
            this.selectedShapeName = '';
          }
          break;
        case "circle" :
          const circle = this.layer.circles.find((r) => r.id === id);
          if (circle) {
            this.selectedShapeName = id;
          } else {
            this.selectedShapeName = '';
          }
          break;
        case "line" :
          const line = this.layer.lines.find((r) => r.id === id);
          if (line) {
            this.selectedShapeName = id;
          } else {
            this.selectedShapeName = '';
          }
          break;
        case "ellipse" :
          const ellipse = this.layer.ellipses.find((r) => r.id === id);
          if (ellipse) {
            this.selectedShapeName = id;
          } else {
            this.selectedShapeName = '';
          }
          break;
      }
      this.updateTransformer();
    },
    handleTransformEndCircle(e) {
      // shape is transformed, let us save new attrs back to the node
      // find element in our state
      const circle = this.layer.circles.find(
          (r) => r.id === this.selectedShapeName
      );
      // update the state
      circle.x = e.target.x();
      circle.y = e.target.y();
      circle.rotation = e.target.rotation();
      circle.scaleX = e.target.scaleX();
      circle.scaleY = e.target.scaleY();
      circle.fill = e.target.fill();
      this.edit(circle.id,circle.type,circle.fill,circle.x,circle.y,circle.radius,0,0,circle.scaleX,circle.scaleY)
    },
    handleTransformEndEllipse(e) {
      // shape is transformed, let us save new attrs back to the node
      // find element in our state
      const ellipse = this.layer.ellipses.find(
          (r) => r.id === this.selectedShapeName
      );
      // update the state
      ellipse.x = e.target.x();
      ellipse.y = e.target.y();
      ellipse.rotation = e.target.rotation();
      ellipse.scaleX = e.target.scaleX();
      ellipse.scaleY = e.target.scaleY();
      ellipse.fill = e.target.fill();
      this.edit(ellipse.id,ellipse.type,ellipse.fill,ellipse.x,ellipse.y,ellipse.radiusX,ellipse.radiusY,ellipse.rotation,ellipse.scaleY,ellipse.scaleX)

    },
    handleTransformEndSquare(e) {
      // shape is transformed, let us save new attrs back to the node
      // find element in our state
      const square = this.layer.squares.find(
          (r) => r.id === this.selectedShapeName
      );
      // update the state
      square.x = e.target.x();
      square.y = e.target.y();
      square.rotation = e.target.rotation();
      square.scaleX = e.target.scaleX();
      square.scaleY = e.target.scaleY();
      square.fill = e.target.fill();
      this.edit(square.id,square.type,square.fill,square.x,square.y,square.width,square.height,square.rotation,square.scaleX,square.scaleY)
      // change fill
      //square.fill = Konva.Util.getRandomColor();

    },
    handleTransformEndLine(e) {
      // shape is transformed, let us save new attrs back to the node
      // find element in our state
      const line = this.layer.lines.find(
          (r) => r.id === this.selectedShapeName
      );
      // update the state
      line.x = e.target.x();
      line.y = e.target.y();
      line.rotation = e.target.rotation();
      line.scaleX = e.target.scaleX();
      line.scaleY = e.target.scaleY();
      line.fill = e.target.fill();
      this.edit(line.id,line.type,line.fill,line.x,line.y,line.points[2],line.points[3],line.rotation,line.scaleX,line.scaleY)
      // change fill
      //line.fill = Konva.Util.getRandomColor();

    },
    handleTransformEndTriangle(e) {
      // shape is transformed, let us save new attrs back to the node
      // find element in our state
      const triangle = this.layer.triangles.find(
          (r) => r.id === this.selectedShapeName
      );
      // update the state
      triangle.x = e.target.x();
      triangle.y = e.target.y();
      triangle.rotation = e.target.rotation();
      triangle.scaleX = e.target.scaleX();
      triangle.scaleY = e.target.scaleY();
      triangle.fill = e.target.fill();
      this.edit(triangle.id,triangle.type,triangle.fill,triangle.x,triangle.y,triangle.radius,triangle.sides,triangle.rotation,triangle.scaleX,triangle.scaleY)
      // change fill
      //triangle.fill = Konva.Util.getRandomColor();

    },
    updateTransformer() {
      // here we need to manually attach or detach Transformer node
      const transformerNode = this.$refs.transformer.getNode();
      const stage = transformerNode.getStage();
      const { selectedShapeName } = this;

      const selectedNode = stage.findOne('#' + selectedShapeName);
      // do nothing if selected node is already attached
      if (selectedNode === transformerNode.node()) {
        return;
      }

      if (selectedNode) {
        //attach to another node
        transformerNode.nodes([selectedNode]);
      } else {
        // remove transformer
        transformerNode.nodes([]);
      }
    },
    refreshBooleans(){
      for(var i in this.booleans ){
          this.booleans[i]= false;
      }
    },
    saveJOSNFile() {
      var path = prompt('Enter path','D:/paint.json')
        this.saveJSON(path)
    },
    saveXMLFile() {
      var path = prompt('Enter path','D:/paint.xml')
      this.saveXML(path)
    },
    loadJSONFile(){
      var path = prompt('Enter path','D:/paint.json')
    },
    loadXMLFile(){
      var path = prompt('Enter path','D:/paint.xml')
      this.loadXML(path)
    },

  },

    // handleDragstart(e) {
    //   // save drag element:
    //   this.dragItemId = e.target.id();
    //   // move current element to the top, by rearranging the items array:
    //   const item = this.items.find((i) => i.id === this.dragItemId);
    //   const index = this.items.indexOf(item);
    //   this.items.splice(index, 1);
    //   this.items.push(item);
    // },
    // handleDragend(e) {
    //   this.dragItemId = null;
    // },
  //   onClickCircleButton(){
  //
  //   }
  //
  // },
  mounted() {
  },
};
</script>

<style scoped>
  .playground{
    border: 7px solid #083556
  }

</style>
