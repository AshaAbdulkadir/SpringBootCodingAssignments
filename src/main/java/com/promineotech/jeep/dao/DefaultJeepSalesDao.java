package com.promineotech.jeep.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.jeep.entity.Image;
import com.promineotech.jeep.entity.ImageMimeType;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author Asha
 *
 */
@Component
@Slf4j
public class DefaultJeepSalesDao implements JeepSalesDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Jeep> fetchJeeps(JeepModel model, String trim) {
		log.debug("DAO: model={}, trim={}", model, trim);
		
		// @formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM models "
				+ "WHERE model_id = :model_id AND trim_level= :trim_level";
		
		// @formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("model_id", model.toString());
		params.put("trim_level", trim);
		
		
		return jdbcTemplate.query(sql, params, 
				new RowMapper<>() {

					@Override
					public Jeep mapRow(ResultSet rs, int rowNum) throws SQLException {
						// @formatter: off
						return Jeep.builder()
								.basePrice(new BigDecimal(rs.getString("base_price")))
								.modelId(JeepModel.valueOf(rs.getString("model_id")))
								.modelPK(rs.getLong("model_pk"))
								.numDoors(rs.getInt("num_doors"))
								.trimLevel(rs.getString("trim_level"))
								.wheelSize(rs.getInt("wheel_size"))
								.build();
						
						// @formatter: on
					}});
	}

	@Override
	public void saveImage(Image image) {
		String sql = "" + "INSERT INTO images ("
				+ "model_fk, image_id, width, height, mime_type, name, data"
				+ ") VALUES ("
				+ ":model_fk, :image_id, :width, :height, :mime_type, :name, :data"
				+ ")";

		Map<String, Object> params = new HashMap<>();

		params.put("model_fk", image.getModelFK());
		params.put("image_id", image.getImageId());
		params.put("width", image.getWidth());
		params.put("height", image.getHeight());
		params.put("mime_type", image.getMimeType().getMimeType());
		params.put("name", image.getName());
		params.put("data", image.getName());

		jdbcTemplate.update(sql, params);

	}

	@Override
	public Optional<Image> retrieveImage(String imageId) {
		String sql = ""
	    		 + "SELECT * "
				 + "FROM images "
	    		 + "WHERE image_id = :image_id";
	     
	     Map<String, Object> params = new HashMap<>();
	     params.put("image_id", imageId);
	     
	     return jdbcTemplate.query(sql, params, new ResultSetExtractor<>() {
	    	 

			@Override
			public Optional<Image> extractData(ResultSet rs) throws SQLException{
				
				if(rs.next()){
					
				//@formatter:off 
				return Optional.of(Image.builder()
						.imagePK(rs.getLong("image_pk"))
						.modelFK(rs.getLong("model_fk"))
						.imageId(rs.getString("image_id"))
						.width(rs.getInt("width"))
						.height(rs.getInt("height"))
						.mimeType(ImageMimeType.fromString(rs.getString("mime_type")))
						.name(rs.getString("name"))
						.data(rs.getBytes("data"))
						.build());
				//@formatter:on
			}
				
			return Optional.empty();
			
			}});
	     
	     /*
	      * No image data in the DBeaver
	      * Download Postman(REST client - API tool) used to upload images to a database- 
	      * by connecting to the real life database - with a running application 
	      */
	     
		}

}
