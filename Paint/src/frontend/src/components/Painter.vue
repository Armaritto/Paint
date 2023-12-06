<template>
  <div>
    <v-stage @click="handleClick" ref="stage" :config="configKonva">
      <v-layer  @wheel= "(event) =>{
        if(this.booleans.resizing){event.target.attrs.radius = Math.max(event.target.attrs.radius-Number(event.evt.deltaY)/20, 5);
          //layer.circles.pop();
        }
         //this.$forceUpdate();
         }"
         @click="(event)=>{
          console.log(event)
          if(this.booleans.filling){

            event.target.attrs.fill = this.c
            var id = Number(event.target.attrs.id)
            changeFill(event.target.attrs,this.c)
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
        <v-circle v-for="circle in this.layer.circles" :config="circle"  ></v-circle>
        <v-ellipse v-for="ellipse in this.layer.ellipses" :config="ellipse"></v-ellipse>
        <v-rect v-for="rect in this.layer.rects" :config="rect"></v-rect>
        <v-rect v-for="square in this.layer.squares" :config="square"></v-rect>
        <v-line v-for="line in this.layer.lines" :config="line"></v-line>
        <v-regular-polygon v-for="shapeConfig in this.layer.triangles" :key="shapeConfig" class="shapeconfig"
                    :config="shapeConfig"></v-regular-polygon>
      </v-layer>
    </v-stage>

  </div>
  <button @click="refreshBooleans(); this.booleans.drawingLine = !this.booleans.drawingLine">line {{this.booleans.drawingLine}}</button>
  <button @click="refreshBooleans(); this.booleans.drawingTriangle = !this.booleans.drawingTriangle">triangle {{this.booleans.drawingTriangle}}</button>
  <button @click="refreshBooleans(); this.booleans.drawingCircle = !this.booleans.drawingCircle">circle {{this.booleans.drawingCircle}}</button>
  <button @click="refreshBooleans(); this.booleans.drawingSquare = !this.booleans.drawingSquare">square {{this.booleans.drawingSquare}}</button>
  <button @click="refreshBooleans(); this.booleans.drawingEllipse = !this.booleans.drawingEllipse">ellipse {{this.booleans.drawingEllipse}}</button>
  <button @click="refreshBooleans(); this.booleans.drawingRectangle = !this.booleans.drawingRectangle">rectangle {{this.booleans.drawingRectangle}}</button>
  <button @click="refreshBooleans(); this.booleans.moving = !this.booleans.moving">move {{this.booleans.moving}}</button>
  <button @click="refreshBooleans(); this.booleans.resizing = !this.booleans.resizing">resize {{this.booleans.resizing}}</button>
  <button @click="refreshBooleans(); this.booleans.filling = !this.booleans.filling">fill {{this.booleans.filling}}</button>
  <div v-if= this.booleans.filling>
    <label for="colorpicker">Color Picker:</label>
    <input v-model="c" type="color" id="colorpicker" value="#ffff33">
  </div>
</template>

<script>
import Konva from "konva";
const width = window.innerWidth;
const height = window.innerHeight;
export default {
  data() {
    return {
      c:'#9933ff',
      changeFill: function (shape, fill) {
        console.log(shape)
        fetch('http://localhost:8080/edit?' + new URLSearchParams({
          id: Number(shape.id),
          type: shape.type,
          fill: fill,
          x: event.pageX,
          y: event.pageY,
          var1: 50,
          var2: 0,
          rotationAngle: 0
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
      parseArrayList: function(ArrayList){
        for(var a in this.layer){
          a = [];
        }
          for(var i in ArrayList){
            var shape= ArrayList[i];
            if(shape.fill === 'null'){
              shape.fill = null
            }
          if(shape.type === "circle"){
            this.layer.circles.push({
              scaleX: 1,
              scaleY: 1,
              id: shape.id.toString(),
              x: shape.x,
              y: shape.y,
              radius: shape.var1,
              fill: shape.fill,
              stroke: 'black',
              strokeWidth: 1,
              draggable: true
            })
          }
          else if(shape.type === "rectangle"){
            this.layer.rects.push({
              scaleX: 1,
              scaleY: 1,
              x: shape.x,
              id: shape.id.toString(),
              y: shape.y,
              width: shape.var2,
              height: shape.var1,
              fill: shape.fill,
              stroke: 'black',
              strokeWidth: 1,
              draggable: true
            })
          }
          else if(shape.type === "triangle"){
            this.layer.triangles.push({
              scaleX: 1,
              scaleY: 1,
              id: shape.id.toString(),
              x: shape.x,
              y: shape.y,
              radius: shape.var1,
              sides: shape.var2,
              fill: shape.fill,
              stroke: 'black',
              strokeWidth: 1,
              draggable: true
            })
          }
          else if(shape.type === "square"){
            this.layer.squares.push({
              x: shape.x,
              id: shape.id.toString(),
              y: shape.y,
              width: shape.var2,
              height: shape.var1,
              fill: shape.fill,
              stroke: 'black',
              strokeWidth: 1,
              draggable: true
            })
          }
          else if(shape.type === "ellipse"){
            this.layer.ellipses.push({
              x: shape.x,
              y: shape.y,
              id: shape.id.toString(),
              radiusX: shape.var1,
              radiusY: shape.var2,
              fill: shape.fill,
              stroke: 'black',
              strokeWidth: 1,
              draggable: true
            })
          }
          else if(shape.type === "line"){
            this.layer.lines.push({
              offsetX: 0,
              offsetY: 0,
              lineJoin: 'round',
              x: shape.x,
              y: shape.y,
              points: [0, 0, shape.var1, shape.var2],
              stroke: 'black',
              strokeWidth:3,
              tension: 0,
              draggable: true
            })
          }
        }
      },
      handle: function() {
      if (this.booleans.drawingCircle == true) {
        fetch('http://localhost:8080/newShape?' + new URLSearchParams({
          id: this.generateId(),
          type: "circle",
          fill: null,
          x: event.pageX,
          y: event.pageY,
          var1: 50,
          var2: 0,
          rotationAngle: 0
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
          x: event.pageX,
          y: event.pageY,
          var1: 100,
          var2: 100,
          rotationAngle: 0
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
          x: event.pageX,
          y: event.pageY,
          var1: 100,
          var2: 150,
          rotationAngle: 0
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
          x: event.pageX,
          y: event.pageY,
          var1: 100,
          var2: 150,
          rotationAngle: 0
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
          x: event.pageX,
          y: event.pageY,
          var1: 100,
          var2: 100,
          rotationAngle: 0
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
          x: event.pageX,
          y: event.pageY,
          var1: 100,
          var2: 3,
          rotationAngle: 0
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
      generateId: function(){return Math.floor(Math.random()*1000000000)},
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
    },
      configKonva: {
        width: width,
        height: height,
      },
      configRect: {
        x: 250,
        y: 250,
        width: 162,
        height: 100,
        stroke: 'black',
        fill: null,
        strokeWidth: 1,
        draggable: true
      },
      configSquare: {
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
        x: 250,
        y: 250,
        radius: 50,
        fill: null,
        stroke: 'black',
        strokeWidth: 1,
        draggable: true
      },
      configEllipse: {
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
      }
      //dragItemId: null,

    };
  },
  methods: {
    handleClick(){
      this.handle()
      // for(var k in this.layer.circles)
      // k.addEventListener("wheel", (event) => {this.layer.circles[k].scale.x *= event.deltaY})
    },
    handleWheel(){
        //var idd =
        console.timeLog(event.deltaY)
        // const item = this.layer.circles.find((i) => i.id === idd);
        // item.scale.x *=2

    },
    refreshBooleans(){
      for(var i in this.booleans ){
          this.booleans[i]= false;
      }
    },

    generateItems() {
      this.items.push({
        x: Math.random() * width,
        y: Math.random() * height,
        radius: 50,
        fill: Konva.Util.getRandomColor(),
        draggable: true,
      });
      return this.items;
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
    onClickCircleButton(){

    }

  },
  mounted() {

  },
};
</script>

<style>
body {
  margin: 0;
  padding: 0;
}
</style>
