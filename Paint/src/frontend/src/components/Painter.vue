<template>
  	<div class="icon-bar">
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	  <a href="save"><i class="fa fa-save"></i></a> 
	  <a href="load"><i class="fa fa-file"></i></a> 
	  <a href="undo"><i class="fa fa-undo"></i></a>
	  <a href="redo"><i class="fa fa-undo" style= "transform: scaleX(-1)"></i></a>
	  <a href="delete"><i class="fa fa-trash"></i></a> 
	</div>
	<div class="sidebar">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<a href="rectangle"><i class="fa fa-fw fa-square"></i> Rect</a>
	  	<a href="circle" @click= "drawCircle()"><i class="fa fa-fw fa-circle"></i> Circle</a>
	  	<a href=""><i class="fa fa-fw fa-user"></i> Ellipse</a>
	  	<a href=""><i class="fa fa-fw fa-envelope"></i> Triangle</a>
	</div>
  <div>
	  <template>
		  <v-stage :config="configKonva">
		    <v-layer>
		      <v-circle :config="configCircle"></v-circle>
		    </v-layer>
		  </v-stage>
		</template>
  </div>
</template>
<script>

export default {
  name: 'Painter',
  
  data() {
    return {
      configKonva: {
        width: 200,
        height: 200
      },
      configCircle: {
        x: 100,
        y: 100,
        radius: 70,
        fill: "red",
        stroke: "black",
        strokeWidth: 4
      }
    };
  },
  
  methods:{
	drawCircle(){
		var layer = new Konva.Layer();
    	layer.add(new Konva.Circle({
  		x: 100,
  		y: 100,
  		radius: 70,
  		fill: 'red',
  		stroke: 'black',
  		strokeWidth: 4, 
		} )
		)
  	}
  }

}
</script>



<style scoped>
body {margin:0;}

.icon-bar {
  width: 100%;
  background-color: #555;
  overflow: auto;
}

.icon-bar a {
  float: left;
  width: 20%;
  text-align: center;
  padding: 12px 0;
  transition: all 0.3s ease;
  color: white;
  font-size: 25px;
}

.icon-bar a:hover {
  background-color: #000;
}

.red-hover:hover {
    background-color: rgb(170, 46, 4);
}


.sidebar {
  height: 88.7%;
  width: 160px;
  position: fixed;
  z-index: 1;
  bottom: 0;
  right: 0;
  background-color: #111;
  overflow-x: hidden;
  padding-top: 16px;
}

/* Style sidebar links */
.sidebar a {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 20px;
  color: #818181;
  display: block;
}

/* Style links on mouse-over */
.sidebar a:hover {
  color: #f1f1f1;
}

/* Style the main content */
.main {
  margin-left: 160px; /* Same as the width of the sidenav */
  padding: 0px 10px;
}

/* Add media queries for small screens (when the height of the screen is less than 450px, add a smaller padding and font-size) */
@media screen and (max-height: 450px) {
  .sidebar {padding-top: 15px;}
  .sidebar a {font-size: 18px;}
}

.canva{
	background-color: green; 
	height: 10px;
 	width: 10px;
}

</style>
