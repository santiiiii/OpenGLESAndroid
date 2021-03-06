package com.example.openglbenchmark;

import android.opengl.GLES20;

public class riGraphicTools {
	 
    // Program variables
    public static int sp_SolidColor;
 
    /* SHADER Solid
     *
     * This shader is for rendering a colored primitive.
     *
     */
    public static final String vs_SolidColor =
        "uniform    mat4        uMVPMatrix;" +
        "attribute  vec4        vPosition;" +
        "void main() {" +
        "  gl_Position = uMVPMatrix * vPosition;" +
        "}";
 
    public static final String fs_SolidColor =
        "precision mediump float;" +
        "void main() {" +
        "  gl_FragColor = vec4(0.5,0,0,1);" +
        "}";
    
    public static final String vertexShader =
    	    "uniform mat4 u_MVPMatrix;      \n"     // A constant representing the combined model/view/projection matrix.
    	 
    	  + "attribute vec4 a_Position;     \n"     // Per-vertex position information we will pass in.
    	  + "attribute vec4 a_Color;        \n"     // Per-vertex color information we will pass in.
    	 
    	  + "varying vec4 v_Color;          \n"     // This will be passed into the fragment shader.
    	 
    	  + "void main()                    \n"     // The entry point for our vertex shader.
    	  + "{                              \n"
    	  + "   v_Color = a_Color;          \n"     // Pass the color through to the fragment shader.
    	                                            // It will be interpolated across the triangle.
    	  + "   gl_Position = u_MVPMatrix   \n"     // gl_Position is a special variable used to store the final position.
    	  + "               * a_Position;   \n"     // Multiply the vertex by the matrix to get the final point in
    	  + "}                              \n";    // normalized screen coordinates.
    
    public static final String fragmentShader =
    	    "precision mediump float;       \n"     // Set the default precision to medium. We don't need as high of a
		            // precision in the fragment shader.
			+ "varying vec4 v_Color;          \n"     // This is the color from the vertex shader interpolated across the
			            // triangle per fragment.
			+ "void main()                    \n"     // The entry point for our fragment shader.
			+ "{                              \n"
			+ "   gl_FragColor = v_Color;     \n"     // Pass the color directly through the pipeline.
			+ "}                              \n";
    
    public static int loadShader(int type, String shaderCode){
 
        // create a vertex shader type (GLES20.GL_VERTEX_SHADER)
        // or a fragment shader type (GLES20.GL_FRAGMENT_SHADER)
        int shader = GLES20.glCreateShader(type);
 
        // add the source code to the shader and compile it
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
 
        // return the shader
        return shader;
    }
}