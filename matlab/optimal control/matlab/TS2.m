function [xT,error]=TS2(h)

N=1/h;
x=zeros(1,N+1);
x(1)=1;

for i=1:N;
    t=(i-1)*h;
    f=(4*(t^3)*x(i))/(1+t^4);
    df=(12*t^2*x(i))/(t^4 + 1) - (16*t^6*x(i))/(t^4 + 1)^2;
    x(i+1)=x(i)+h*f+((h^2)/2)*df;
end

xT=x(N+1);
error=abs((1+1^4)-x(N+1));