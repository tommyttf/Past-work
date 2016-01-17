function [x,m]= assig2qu3(N)

h=1/N;
A=zeros(N-1,N-1);
b=zeros(N-1,1);
exactx=zeros(N-1,1);
t=linspace(h,1-h,N-1);
x=zeros(N-1,1);

for i=1:N-1
    for j=1:N-1
        if i==j
            A(i,j)=-2-h^2;
        elseif ((i==j+1)||(i==j-1))
            A(i,j)=1;
        else
            A(i,j)=0;
        end
    end
    
    b(i)=h^2;
    exactx(i)=(exp(t(i))*(1-1/exp(1))+exp(-1*t(i))*(-1+exp(1))-(exp(1)-1/exp(1)))/(exp(1)-1/exp(1));
end

for i = 1:N-1
    a = -A(i+1:N-1,i)/A(i,i); 
    A(i+1:N-1,:) = A(i+1:N-1,:) + a*A(i,:);
    b(i+1:N-1,:) = b(i+1:N-1,:) + a*b(i,:);
end;

x(N-1,:) = b(N-1,:)/A(N-1,N-1);

for i = N-2:-1:1
    x(i,:) = (b(i,:) - A(i,i+1:N-1)*x(i+1:N-1,:))/A(i,i);
end

m=max(abs(x-exactx));