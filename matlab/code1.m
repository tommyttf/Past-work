%The input value u0 is the initial guess for u,
%N is number of time interval we want to have,
%output value k is the number of time of iteration

function [y,k]=code1(A,B,C,x0,u0,N)

test=-1;

delta=0.001;
t=linspace(0,1,N+1);
h=1/N;
h2=h/2;
k=0;              

u=u0*diag(eye(N+1,N+1))';

x=zeros(1,N+1);
x(1)=x0;
lambda=zeros(1,N+1);

while(test<0)
    
    oldu=u;
    oldx=x;
    oldlambda=lambda;
    k=k+1;
    
    for i =1:N
        k1=dx(C,x(i),u(i));                     %using dx.m
        k2=dx(C,x(i)+h2*k1,0.5*(u(i)+u(i+1)));
        k3=dx(C,x(i)+h2*k2,0.5*(u(i)+u(i+1)));
        k4=dx(C,x(i)+h*k3,0.5*(u(i+1)));
        x(i+1)=x(i)+(h/6)*(k1+2*k2+2*k3+k4);
    end
    
    for i =1:N
        j=N+2-i;
        k1=dlambda(A,x(j),lambda(j));           %using dlambda.m
        k2=dlambda(A,0.5*(x(j)+x(j-1)),lambda(j)-h2*k1);
        k3=dlambda(A,0.5*(x(j)+x(j-1)),lambda(j)-h2*k2);
        k4=dlambda(A,x(j-1),lambda(j)-h*k3);
        lambda(j-1)=lambda(j)-(h/6)*(k1+2*k2+2*k3+k4);
    end
    
    u1=C*lambda/(2*B);
    u=0.5*(u1+oldu);
    
    temp1=delta*sum(abs(u))-sum(abs(oldu-u));
    temp2=delta*sum(abs(x))-sum(abs(oldx-x));
    temp3=delta*sum(abs(lambda))-sum(abs(oldlambda-lambda));
    test=min(temp1,min(temp2,temp3));
end

y(1,:)=t;
y(2,:)=x;
y(3,:)=lambda;
y(4,:)=u;

subplot(3,1,1)
plot(y(1,:),y(2,:),'Color','b')
ylabel('state')
xlabel('time')
hold all
subplot(3,1,2)
plot(y(1,:),y(3,:),'Color','b')
ylabel('adjoint')
xlabel('time')
hold all
subplot(3,1,3)
plot(y(1,:),y(4,:),'Color','b')
ylabel('control')
xlabel('time')
hold all