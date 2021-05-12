package WCalc;
import java.util.List;
import java.io.IOException;

import Math.Accessory;
import Math.FrameColor;
import Math.FrameMaterial;
import Math.FrameType;
import Math.GlassUnit;
import Math.OpeningMechanism;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Calc", urlPatterns="/JavaCalc")
public class Calc extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		 
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
		
	}

static public double getWindowFrameCost(int height, int width, FrameType frameType, FrameMaterial frameMaterial) {
		double rubblesCoef = 0.001;
		double frameTypeCoef = 0;
		double frameMaterialCoef = 0;
		
		switch (frameType) {
		case SINGLELEAF:
			frameTypeCoef = 1;
			break;
		case BIVALVE:
			frameTypeCoef = 1.2;
			break;
		case BIVALVETRANSOM:
			frameTypeCoef = 1.35;
			break;
		case TRICUSPID:
			frameTypeCoef = 1.4;
			break;
		case TRICUSPIDTRANSOM:
			frameTypeCoef = 1.55;
			break;
		}
		
		switch (frameMaterial) {
		case PVC:
			frameMaterialCoef = 1;
			break;
		case WOOD:
			frameMaterialCoef = 1.2;
			break;
		case METAL:
			frameMaterialCoef = 1.4;
			break;
		}
		return (height * width) * rubblesCoef * frameMaterialCoef * frameTypeCoef;
	}

	// ������ ��������� ���������� ����������
	static public double getLeafCost(List<OpeningMechanism> mechanisms) {
		double cost = 0;
		for (OpeningMechanism mechanism : mechanisms) {
			switch (mechanism) {
			case FOLDING:
				cost += 300;
				break;
			case SWIVIEL:
				cost += 400;
				break;
			case SWINGOUT:
				cost += 700;
				break;
			default:
				break;
			}
		}
		return cost;
	}
	
	// ������ ��������� ������������
	static public double getGlassUnitCost(int height, int width, GlassUnit unit) {
		double coef = 0.001;
		double glassUnitCoef = unit == GlassUnit.DOUBLEGLAZED ? 1 : 1.2;
		return height * width * coef * glassUnitCoef;
	}
	
	// ������ ��������� �����������
	static public double getAccessoriesCost(int width, Accessory acc) {
		double result = 0;
		switch (acc) {
		case CORNISE:
			result = width * 0.2;
			break;
		case SILL:
			result = width * 0.6;
			break;
		case BOTH:
			result = width * 0.8;
			break;
		}
		return result;
	}

	// ������ �������� ���������
	static public double getResultSum(double frameCost, double leafCost, double glassCost, double accCost, FrameColor frameColor, double promo) {
		double frameColorCoef = frameColor == FrameColor.WHITE ? 1 : 1.05;
		return ((frameCost + leafCost + glassCost + accCost) * frameColorCoef) * promo; 
	}